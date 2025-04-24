
package com.example.ride_sharing;

        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.boot.autoconfigure.domain.EntityScan;
        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.context.annotation.FilterType;
        import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
        import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableJpaRepositories(
        basePackages = "com.example.ride_sharing.repositories",
        includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
                com.example.ride_sharing.repositories.CaptainRepository.class,
                com.example.ride_sharing.repositories.CustomerRepository.class,
                com.example.ride_sharing.repositories.PaymentRepository.class,
                com.example.ride_sharing.repositories.TripRepository.class,
        })
)
@EnableMongoRepositories(
        basePackages = "com.example.ride_sharing.repositories",
        includeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {
                com.example.ride_sharing.repositories.RatingRepository.class
        })
)
@EntityScan(basePackages = "com.example.ride_sharing.models")
public class RideSharingApplication {
    public static void main(String[] args) {
        SpringApplication.run(RideSharingApplication.class, args);
    }
}