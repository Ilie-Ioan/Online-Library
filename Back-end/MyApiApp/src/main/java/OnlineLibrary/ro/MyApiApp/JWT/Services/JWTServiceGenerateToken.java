package OnlineLibrary.ro.MyApiApp.JWT.Services;

import OnlineLibrary.ro.MyApiApp.JWT.Interfaces.IGenerateToken;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class JWTServiceGenerateToken implements IGenerateToken {

    private static final long VALADITY = TimeUnit.MINUTES.toMillis(30);
    private final JWTGenerateKey jwtGenerateKey;

    public JWTServiceGenerateToken(JWTGenerateKey jwtGenerateKey) {
        this.jwtGenerateKey = jwtGenerateKey;
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(Date.from(Instant.now()))
                .expiration(Date.from(Instant.now().plusMillis(VALADITY)))
                .signWith(jwtGenerateKey.generateKey())
                .compact();
    }

}
