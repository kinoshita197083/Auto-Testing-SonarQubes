package test;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class CustomArgumentSource implements ArgumentsProvider{

    public static Stream<Arguments> provideTwoNumbersForAddition() {
        return Stream.of(
                Arguments.of("Tokyo", "Sydney")
        );
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        // TODO Auto-generated method stub
        return Stream.of(
                Arguments.of("Tokyo", "Sydney")
        );
    }
}
