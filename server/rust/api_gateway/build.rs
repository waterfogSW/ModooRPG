use std::io::Result;
use std::path::{Path, PathBuf};

const PROTO_DIR: &str = "../../../proto";
const PROTO_EXT: &str = "proto";

fn main() -> Result<()> {
    compile_protos(PROTO_DIR)?;
    Ok(())
}

fn compile_protos(proto_dir: &str) -> Result<()> {
    let proto_dir = PathBuf::from(proto_dir);
    println!("cargo:rerun-if-changed={}", proto_dir.display());

    let proto_files = find_proto_files(&proto_dir)?;
    println!("Found proto files: {:?}", proto_files);

    if proto_files.is_empty() {
        println!("No proto files found in {}", proto_dir.display());
        return Ok(());
    }

    tonic_build::configure()
        .build_server(true)
        .build_client(true)
        .compile(&proto_files, &[&proto_dir])?;

    Ok(())
}

fn find_proto_files(dir: &Path) -> Result<Vec<PathBuf>> {
    let mut proto_files = Vec::new();
    if dir.is_dir() {
        for entry in std::fs::read_dir(dir)? {
            let entry = entry?;
            let path = entry.path();
            if path.is_dir() {
                proto_files.extend(find_proto_files(&path)?);
            } else if path.extension().and_then(|s| s.to_str()) == Some(PROTO_EXT) {
                proto_files.push(path);
            }
        }
    }
    Ok(proto_files)
}
