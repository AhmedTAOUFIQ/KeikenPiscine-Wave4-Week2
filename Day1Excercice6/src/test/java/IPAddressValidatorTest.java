import org.example.IpAddressValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IPAddressValidatorTest {
    private IpAddressValidator validator;
    @BeforeEach
    void setUp(){
        validator=new IpAddressValidator();
    }
    @Test
    public void itShouldAcceptWhenIpIs1111(){

        String ipAddress = "1.1.1.1";
        boolean isValid = validator.ValidateIpv4Address(ipAddress);
        assertTrue(isValid);
    }
    @Test
    public void shouldValidateWhenAddressHas4PartsBetween0And255(){
        String ipAddress = "192.168.1.1";
        boolean isValid = validator.ValidateIpv4Address(ipAddress);
        assertEquals(isValid,true);
    }
    @Test
    public void shouldNotValidateWhenLastPartIs0(){
        String ipAddress = "192.168.1.0";
        boolean isValid = validator.ValidateIpv4Address(ipAddress);
        assertEquals(isValid,false);
    }
    @Test
    public void shouldNotValidateWhenLastPartIs255(){
        String ipAddress = "192.168.1.255";
        boolean isValid = validator.ValidateIpv4Address(ipAddress);
        assertEquals(isValid,false);
    }

    @Test
    public void shouldNotValidateWhenThereIsLessThan4Parts(){
        String ipAddress = "192.168.1";
        boolean isValid = validator.ValidateIpv4Address(ipAddress);
        assertEquals(isValid,false);
    }
    @Test
    public void shouldNotValidateWhenThereIsMoreThan4Parts(){
        String ipAddress = "192.168.1.24.65";
        boolean isValid = validator.ValidateIpv4Address(ipAddress);
        assertEquals(isValid,false);
    }
    @Test
    public void shouldNotValidateWhenAPartIsOutOfTheRange(){
        String ipAddress = "192.168.1.744";
        boolean isValid = validator.ValidateIpv4Address(ipAddress);
        assertEquals(isValid,false);
    }

}
