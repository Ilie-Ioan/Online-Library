package OnlineLibrary.ro.MyApiApp.JWT.Services;

import OnlineLibrary.ro.MyApiApp.JWT.Interfaces.IGenerateKey;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Base64;

public class JWTGenerateKey implements IGenerateKey {

    private final String Secret = "E921C9CFD2419279EAA4893A78E4DC7EBAB6DE1D22C06270BD4E9FAEE53092A8077F64378714C97256ADBFC8BBAB892813F7CED23500B31EC31670EF3E8026F8";

    @Override
    public SecretKey generateKey() {
        byte[] decodedkey = Base64.getDecoder().decode(Secret);
        return Keys.hmacShaKeyFor(decodedkey);
    }
}
