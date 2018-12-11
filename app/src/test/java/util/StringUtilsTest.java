package util;

import android.app.Activity;
import android.os.IBinder;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.File;

import swati4star.createpdf.util.StringUtils;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

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

    @Test
    public void when_CallingHideKeyboard_Expect_MethodsCalled() {
        View mockView = Mockito.mock(View.class);
        when(mockView.getWindowToken()).thenReturn(null);

        InputMethodManager mockInputMethodManager = Mockito.mock(InputMethodManager.class);

        Activity mockActivity = Mockito.mock(Activity.class);
        when(mockActivity.getSystemService(ArgumentMatchers.eq(Activity.INPUT_METHOD_SERVICE)))
                .thenReturn(mockInputMethodManager);
        when(mockActivity.getCurrentFocus()).thenReturn(mockView);

        StringUtils.hideKeyboard(mockActivity);

        verify(mockActivity, times(1)).getSystemService(Activity.INPUT_METHOD_SERVICE);
        verify(mockActivity, times(1)).getCurrentFocus();
        verify(mockInputMethodManager, times(1))
                .hideSoftInputFromWindow(
                        ArgumentMatchers.isNull(),
                        ArgumentMatchers.eq(0));
    }

}


