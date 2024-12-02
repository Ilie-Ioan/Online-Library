package OnlineLibrary.ro.MyApiApp.Login;

import OnlineLibrary.ro.MyApiApp.User.Services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return  http
               .csrf(AbstractHttpConfigurer::disable)
               .authorizeHttpRequests(registry ->{
                   registry.requestMatchers("/home","/auth/**").permitAll();
                   registry.requestMatchers("/admin/**").hasRole("ADMIN");
                   registry.requestMatchers("/user/**").hasRole("USER");
                   registry.anyRequest().authenticated();
               })
               .formLogin(httpSecurityFormLoginConfigurer -> {
                   httpSecurityFormLoginConfigurer
                           .loginPage("/login")
                           .successHandler(new AuthentificationSuccesHandler())
                           .permitAll();
               })
               .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
