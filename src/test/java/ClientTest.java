import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();
  
@Test
  public void client_getClientName_String() {
<<<<<<< HEAD
  	Client firstClient =  new Client("Client Jane", 1);
  	Client secondClient = new Client("Client Jane", 1);
=======
  	Client firstClient =  new Client("Client Jane");
  	Client secondClient = new Client("Client Jane");
>>>>>>> ce44c89af7a326666c57c5cbd788c446219eb77b
  	assertTrue(firstClient.equals(secondClient));

  }

  @Test
  public void client_saveClientNametoList_true() {
<<<<<<< HEAD
    Stylist myStylist  = new Stylist("Stylist");
    myStylist.save();
    Client myClient = new Client("Client Jane", myStylist.getId());
    myClient.save();
    assertEquals(Client.all().get(0), myStylist);
=======
    Client myClient = new Client("Client Jane");
    myClient.save();
    assertTrue(Client.all().get(0).equals(myClient));
>>>>>>> ce44c89af7a326666c57c5cbd788c446219eb77b
  }

  //  @Test
  // public void save_saveStylistIdIntoDB_true() {
  //   Stylist myStylist = new Stylist ("Stylist Name 1");
  //   myStylist.save();
  //   Client myClient = new Client ("Client Name 1", myStylist.getId());
  //   myClient.save();
  //   Client savedClient = Client.find(myClient.getId());
  //   assertEquals(savedClient.getStylistId(), myStylist.getId());
  // }

  @Test
  public void getId_categoriesInstiateWithAnId_1() {
<<<<<<< HEAD
  	    Stylist myStylist  = new Stylist("Stylist");
    myStylist.save();
    Client myClient = new Client("Client Jane", myStylist.getId());
    myClient.save();
  	assertTrue(myClient.getId() > 0);
=======
  	Client testClient = new Client("Client Jane");
  	testClient.save();
  	assertTrue(testClient.getId() > 0);
>>>>>>> ce44c89af7a326666c57c5cbd788c446219eb77b
  }

  @Test
  public void delete_deletesClients_true() {
<<<<<<< HEAD
  	    Stylist myStylist  = new Stylist("Stylist");
    myStylist.save();
    Client myClient = new Client("Client Jane", myStylist.getId());
=======
  	Client myClient = new Client("Client Jane");
>>>>>>> ce44c89af7a326666c57c5cbd788c446219eb77b
    myClient.save();
    int myClientId = myClient.getId();
    myClient.delete();
    assertEquals(null, Client.find(myClientId));
  }
}