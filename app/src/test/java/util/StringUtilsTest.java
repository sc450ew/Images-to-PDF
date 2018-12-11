package util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import static swati4star.createpdf.util.StringUtils.isEmpty;
import static swati4star.createpdf.util.StringUtils.isNotEmpty;

@RunWith(MockitoJUnitRunner.class)
public class StringUtilsTest {

    private static final String EMPTY_STRING = "";
    private static final String NOT_EMPTY_STRING = "not_empty_string";

    @Test
    public void when_CallingIsEmpty_Expect_CorrectValueReturned() {
        assertThat(isEmpty(EMPTY_STRING), is(true));
        assertThat(isEmpty(NOT_EMPTY_STRING), is(false));
    }

    @Test
    public void when_CallingIsNotEmpty_Expect_CorrectValueReturned() {
        assertThat(isNotEmpty(EMPTY_STRING), is(false));
        assertThat(isNotEmpty(NOT_EMPTY_STRING), is(true));
    }

}


