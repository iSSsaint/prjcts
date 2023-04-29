package ma.ac.emi.ginfo.elkihelayman.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("password")
                .roles("ADMIN")
                .build();
        UserDetails operateur = User.withDefaultPasswordEncoder()
                .username("operateur")
                .password("password")
                .roles("OPERATEUR", "USER")
                .build();
        UserDetails responsable = User.withDefaultPasswordEncoder()
                .username("responsable")
                .password("password")
                .roles("RESPONSABLE", "USER" )
                .build();
        return new InMemoryUserDetailsManager(user, operateur, admin, responsable);
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(auth -> {
                    auth.requestMatchers("/").permitAll();
                    auth.requestMatchers("/responsable/**").hasRole("ADMIN");
                    auth.requestMatchers("/operateur/**").hasRole("ADMIN");
                    auth.requestMatchers("/employe/**").hasRole("ADMIN");
                    auth.requestMatchers("/employe").hasRole("ADMIN");
                    auth.requestMatchers("/usine/**").hasRole("ADMIN");
                    auth.requestMatchers("/moteur/**").hasRole("RESPONSABLE");
                    auth.requestMatchers("/modele/**").hasRole("RESPONSABLE");
                    auth.requestMatchers("/defaut/**").hasRole("OPERATEUR");
                    auth.requestMatchers("/type/**").hasRole("OPERATEUR");
                })
                .httpBasic(withDefaults())
                .build();
    }

}
