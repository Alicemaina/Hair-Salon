
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();


    @Test
  public void equals_returnsTrueIfNamesAretheSame() {
  Stylist fristStylist = new Stylist("Ann");
  Stylist secondStylist = new Stylist("Ann");
  assertTrue(fristStylist.equals(secondStylist));
  }

  //  save into Database
  @Test
  public void save_returnTrueIfNameAretheSame() {
  	Stylist myStylist = new Stylist("Ann");
  	myStylist.save();
  	assertTrue(Stylist.all().get(0).equals(myStylist));

  }

  @Test
  public void find_returnsStylistSameId_secondStylist() {
  	Stylist fristStylist = new Stylist("Ann");
  	fristStylist.save();
  	Stylist secondStylist = new Stylist ("Jenffer");
  	secondStylist.save();
  	assertEquals(Stylist.find(secondStylist.getId()), secondStylist);

  }

  @Test
  public void delete_deletesStylist_true() {
  	Stylist myStylist = new Stylist("Ann");
  	myStylist.save();
    int myStylistId = myStylist.getId();
    myStylist.delete();
    assertEquals(null, Stylist.find(myStylistId));
  }
}

 

// 	@Test 
// 	public void StylistAreThesame(){
// 		Stylist fristStylist = new Stylist("Stylist_name1");
// 		Stylist secondStylist = new Stylist("Stylist_name1");
// 		assertTrue(fristStylist.equals(secondStylist));
// 	}
// 	// Public void Stylist_OwerAddStylist_true() {
// 	// 	Stylist newStylist = new Stylist("Stylist_name1");
// 	// 	assertEquals(true, newStylist instanceof Stylist);
// 	// }


// }