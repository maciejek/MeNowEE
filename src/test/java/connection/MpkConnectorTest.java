package connection;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * Created by maciek on 23.01.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class MpkConnectorTest {

    @Mock
    private MpkDataGetter mpkDataGetter;

    @org.junit.Test
    public void shouldConnectConsiderOnlyLinesFromGivenStop() throws Exception {
        String given = "{\"21112\":{\"board\":[{\"line\":\"246\",\"minuteCount\":21,\"routeBegin\":false,\"currentStop\":{\"s\":\"12110\",\"x\":16.960846,\"y\":51.11239,\"t\":\"b\",\"n\":\"NOWY DWÓR\u0093R\",\"symbol\":\"12110\",\"name\":\"NOWY DWĂ\u0093R\"},\"nextStop\":{\"s\":\"12108\",\"x\":16.964947,\"y\":51.113846,\"t\":\"b\",\"n\":\"NOWODWORSKA\",\"symbol\":\"12108\",\"name\":\"NOWODWORSKA\"},\"code\":7017,\"direction\":\"SOŁTYSOWICE\",\"distance\":-22,\"floor\":\"l\",\"ac\":false,\"lag\":16500,\"delay\":-1415,\"departure\":\"00:23\",\"scheduledDeparture\":\"Jan 2, 1900 12:23:00 AM\",\"scheduledDepartureTime\":\"00:23\"},{\"line\":\"243\",\"minuteCount\":22,\"routeBegin\":true,\"currentStop\":{\"s\":\"25134\",\"x\":17.0975,\"y\":51.069958,\"t\":\"b\",\"n\":\"KSIÄ\u0098ĹťE WIELKIE\",\"symbol\":\"25134\",\"name\":\"KSIÄ\u0098ĹťE WIELKIE\"},\"nextStop\":{\"s\":\"25132\",\"x\":17.0948,\"y\":51.069,\"t\":\"b\",\"n\":\"BROCHOWSKA\",\"symbol\":\"25132\",\"name\":\"BROCHOWSKA\"},\"code\":8070,\"direction\":\"LEŚNICA\",\"distance\":-12,\"floor\":\"l\",\"ac\":false,\"lag\":1537,\"delay\":0,\"departure\":\"00:25\",\"scheduledDeparture\":\"Jan 1, 1900 12:25:00 AM\",\"scheduledDepartureTime\":\"00:25\"}],\"name\":\"PETRUSEWICZA\",\"direction\":\"122 -\\u003e PETRUSEWICZA, 243 -\\u003e LEĹ\u009ANICA, 243 -\\u003e KSIÄ\u0098ĹťE WIELKIE, 246 -\\u003e PETRUSEWICZA, 246 -\\u003e KOZANĂ\u0093W, 246 -\\u003e Ĺ\u009AWINIARY (PÄ\u0098TLA), 246 -\\u003e SOĹ\u0081TYSOWICE, 251 -\\u003e LITEWSKA (PÄ\u0098TLA), 259 -\\u003e WOJSZYCKA, 602 -\\u003e PETRUSEWICZA, D -\\u003e PETRUSEWICZA, N -\\u003e PETRUSEWICZA, \",\"id\":\"21112\"}}";

        when(mpkDataGetter.getResponse("21112")).thenReturn(given);
        MpkConnector mpkConnector = new MpkConnector(mpkDataGetter);
        Collection<News> result = mpkConnector.connect();

        assertThat(result.size(), is(2));
        assertThat(result.contains("246, SOŁTYSOWICE, 21"), is(true));
        assertThat(result.contains("243, LEŚNICA, 22"), is(true));
    }

}