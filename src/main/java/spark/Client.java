import java.util.List;
import org.sql2o.*;

import java.util.List;
import org.sql2o.*;

public class Client {
	private String name;
	private int id;
	private int contact;
	private int stylistId;
	private String clientId;




	public Client(String name, int stylistId) {
		this.stylistId = stylistId;
    this.clientId = clientId;
		this.name = name;
	}

	public String getClientId() {
		return clientId;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public int getStylistId() {
    return stylistId;
  }

	public int getContact() {
		return contact;
	}

	 public static List<Client> all() {
        String sql = "SELECT * FROM clients";
        try(Connection con = DB.sql2o.open()) {
         return con.createQuery(sql).executeAndFetch(Client.class);
        }
  }

  // Overrinding
  @Override
  public boolean equals(Object anotherClient) {
    if(!(anotherClient instanceof Client)){
      return false;
    }else {
      Client newClient = (Client) anotherClient;
      return this.getName().equals(newClient.getName()) &&
      this.getId() == newClient.getId() &&
      this.getStylistId() == newClient.getStylistId();
    }
  }

 public void save(){
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients (name, stylistId) VALUES (:name, :stylistId)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("stylistId", this.stylistId)
      .executeUpdate()
      .getKey();
    }
  }

  public static Client find (int id) {
  	try(Connection con =DB.sql2o.open()) {
  		String sql = "SELECT * FROM clients WHERE id=:id";
  		  Client client = con.createQuery(sql)
  		  .addParameter("id", id)
  		  .executeAndFetchFirst(Client.class);
  		   return client;

  	}
  }

  public void update(String name) {
  	try(Connection con = DB.sql2o.open()) {
  		String sql = "UPDATE clients SET name = :nameWHERE id=:id";
  		con.createQuery(sql)
  		.addParameter("name", name)
  		.addParameter("id", id)
  		.executeUpdate();
  	}
  }
  public void delete() {
  	try(Connection con = DB.sql2o.open()) {
  		String sql = "DELETE FROM clients WHERE id = :id;";
  		con.createQuery(sql)
  		.addParameter("id", id)
  		.executeUpdate();
  	}
  }

}