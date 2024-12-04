package OnlineLibrary.ro.MyApiApp;

import io.jsonwebtoken.Jwts;
import jakarta.xml.bind.DatatypeConverter;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.parameters.P;

import javax.crypto.SecretKey;

public class JwtSecretMakerTest {

    @Test
    public  void generateSecretKey()
    {
        SecretKey key = Jwts.SIG.HS512.key().build();
        String encodedKey = DatatypeConverter.printHexBinary(key.getEncoded());
        System.out.printf("\n Key = [%s]\n",encodedKey);
    }
}
