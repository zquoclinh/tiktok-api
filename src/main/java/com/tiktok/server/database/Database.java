package com.tiktok.server.database;

import com.tiktok.server.models.User;
import com.tiktok.server.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Database {
//    logger
//    private static final Logger logger = LoggerFactory.getLogger(Database.class);
//   @Bean
//    CommandLineRunner initDatabase(UserRepository userRepository){
//       return new CommandLineRunner() {
//           @Override
//           public void run(String... args) throws Exception {
//               User userA = new User("Đào Lê", "Phương Hoa", "Đào Lê Phương Hoa","hoaahanassii","","",true, 1, 30, 1000, "", "","", "","");
//               logger.info("insert data: "+userRepository.save(userA));
//           }
//       };
//   }

}
