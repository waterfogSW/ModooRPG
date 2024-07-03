mod config;
mod error;

use std::error::Error;


#[tokio::main]
async fn main() -> Result<(), Box<dyn std::error::Error>> {
    tracing_subscriber::fmt::init();

    let config = config::load_config()?;

    Ok(())
}
