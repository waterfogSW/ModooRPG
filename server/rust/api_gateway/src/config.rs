use config::{Config, ConfigError, Environment, File};
use serde::Deserialize;

const CONFIG_FILE: &str = "application.yaml";

#[derive(Debug, Deserialize)]
pub struct Settings {
    pub websocket: WebSocketConfig,
    pub kafka: KafkaConfig,
}

#[derive(Debug, Deserialize)]
pub struct WebSocketConfig {
    pub host: String,
    pub port: u16,
}

#[derive(Debug, Deserialize)]
pub struct KafkaConfig {
    pub bootstrap_servers: String,
    pub topic: String,
}

pub fn load_config() -> Result<Settings, ConfigError> {
    let config = Config::builder()
        .add_source(File::with_name("config"))
        .add_source(Environment::with_prefix("app"))
        .build()?;

    config.try_deserialize()
}
