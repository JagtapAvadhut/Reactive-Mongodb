//package com.spring.reactive.config;
//
//import com.datastax.oss.driver.api.core.CqlSession;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
//import org.springframework.data.cassandra.core.ReactiveCassandraTemplate;
//import org.springframework.data.cassandra.core.CassandraTemplate;
//import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
//
//@Configuration
//@EnableCassandraRepositories(basePackages = "com.spring.reactive.repository")
//public class CassandraConfig extends AbstractCassandraConfiguration {
//
//    /*
//     * Provide contact points and keyspace name to the configuration.
//     */
//    @Override
//    public String getContactPoints() {
//        return "localhost";  // Replace with your contact points (e.g., Docker, localhost, or cloud address)
//    }
//
//    @Override
//    public String getKeyspaceName() {
//        return "mykeyspace";  // Replace with your actual keyspace
//    }
//
////    @Override
////    public String getLocalDatacenter() {
////        return "datacenter1";  // Replace with your Cassandra datacenter name
////    }
//
////    @Override
////    protected void configureClient(CqlSession.Builder builder) {
////         Optional: Configure the CqlSession with additional settings if needed
////        builder.withLocalDatacenter(getLocalDatacenter());
////    }
//
//    @Bean
//    public ReactiveCassandraTemplate reactiveCassandraTemplate(CqlSession cqlSession) {
//        // Create and return a ReactiveCassandraTemplate for reactive data access
//        return new ReactiveCassandraTemplate(session());
//    }
//
//    @Bean
//    public CassandraTemplate cassandraTemplate(CqlSession cqlSession) {
//        // Create and return a CassandraTemplate for non-reactive data access
//        return new CassandraTemplate(cqlSession);
//    }
//
//    public @Bean CqlSession session() {
//        return CqlSession.builder().withKeyspace("mykeyspace").build();
//    }
//}
