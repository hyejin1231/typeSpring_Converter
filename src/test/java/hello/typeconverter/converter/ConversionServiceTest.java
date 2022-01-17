package hello.typeconverter.converter;

import hello.typeconverter.type.ipPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.*;

public class ConversionServiceTest {

    @Test
    void conversionService() {
        // 등록
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        // 사용
        Integer result = conversionService.convert("10", Integer.class);
        System.out.println("result = " + result);
        assertThat(result).isEqualTo(10);
        assertThat(conversionService.convert(10, String.class)).isEqualTo("10");
        ipPort result2 = conversionService.convert("127.0.0.1:8080", ipPort.class);
        assertThat(result2).isEqualTo(new ipPort("127.0.0.1", 8080));
        String ipPortString = conversionService.convert(new ipPort("127.0.0.1", 8080), String.class);
        assertThat(ipPortString).isEqualTo("127.0.0.1:8080");
    }
}
