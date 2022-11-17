import com.audio.SongNameByAlphabet;
import com.audio.Songslist;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JukeBoxTest
{
    Songslist songslist;
    SongNameByAlphabet songNameByAlphabet=null;
    @Before
    public void SetUp()
    {
        songNameByAlphabet =new SongNameByAlphabet();
    }
    @After
    public void tearDown()
    {
        songNameByAlphabet=null;
        songslist=null;
    }

    @Test
    public void sortSongsName() throws SQLException, ClassNotFoundException {

        List<Songslist> output = SongNameByAlphabet.SortSongNameByAlphabet();
     assertEquals("Dil Janiye",output.get(0).getSongsName());
    }

}
