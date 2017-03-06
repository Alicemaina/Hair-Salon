import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();
  
@Test
   public void client_getClientName_String() {
    Client firstClient =  new Client("Jane", 1);
    Client secondClient = new Client("Jane", 1);
    assertTrue(firstClient.equals(secondClient));

  }

  // @Test
  //  public void returnsALLInsatncesOfClient_true() {
  //   Client firstClient =  new Client("Jane", myStylist.getId());
  //   firstClient.save();
  //   Client secondClient = new Client("Jane", myStylist.getId());
  //   secondClient.save();
  //   assertEquals(true, Client.all().get(0).equals(firstClient));
  //   assertEquals(true, Client.all().get(1).equals(secondClient));


  // }

  // @Test
  // public void client_saveClientNametoList_true() {
  //   Stylist myStylist  = new Stylist("Ann");
  //   myStylist.save();
  //   Client myClient = new Client("Jane", myStylist.getId());
  //   myClient.save();
  //   assertEquals(Client.get(0), myStylist);

  // }

   @Test
  public void save_saveStylistIdIntoDB_true() {
    Stylist myStylist = new Stylist ("Ann");
    myStylist.save();
    Client myClient = new Client ("Jane", myStylist.getId());
    myClient.save();
    Client savedClient = Client.find(myClient.getId());
    assertEquals(savedClient.getStylistId(), myStylist.getId());
  }

  @Test
  public void getId_clientsInstiateWithAnId_1() {
  	Stylist myStylist  = new Stylist("Ann");
    myStylist.save();
    Client myClient = new Client("Jane", myStylist.getId());
    myClient.save();
  	assertTrue(myClient.getId() > 0);

  }

  @Test
  public void delete_deletesClients_true() {
  	Stylist myStylist  = new Stylist("Ann");
    myStylist.save();
    Client myClient = new Client("Jane", myStylist.getId());
    myClient.save();
    int myClientId = myClient.getId();
    myClient.delete();
    assertEquals(null, Client.find(myClientId));
  }
}