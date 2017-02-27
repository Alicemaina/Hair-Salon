import java.util.List;
import org.sql2o.*;

public class Stylist {
	private String name;
	private int id;
	private int contact;


	public Stylist(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public int getContact() {
		return contact;
	}

	

	@Override 
	public boolean equals(Object otherStylist) {
		if(!(otherStylist instanceof Stylist)) {
			return false;
		} else {
			Stylist newStylist = (Stylist) otherStylist;
			return this.getName().equals(newStylist.getName());
		}
	}

	public static List<Stylist> all() {
<<<<<<< HEAD
    try (Connection con = DB.sql2o.open()) {
    String sql = "SELECT * FROM stylists";
=======
    String sql = "SELECT * FROM stylists";
    try (Connection con = DB.sql2o.open()) {
>>>>>>> ce44c89af7a326666c57c5cbd788c446219eb77b
      return con.createQuery(sql).executeAndFetch(Stylist.class);
    }
  }

	 public List<Client> getClient() {
	 	try(Connection con = DB.sql2o.open()) {
	 		String sql = "SELECT * FROM client WHERE stylistId=:id";
	 		return con.createQuery(sql)
	 		.addParameter("id", this.id)
	 		.executeAndFetch(Client.class);
	 	}
	 }
 

	public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stylists(name) VALUES (:name)";
      this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .executeUpdate()
      .getKey();
    }
   }

   public static Stylist find (int id) {
    try (Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM stylists WHERE id=:id;";
      Stylist stylist = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Stylist.class);
      return stylist;
    }
  }

  public void delete() {
  	try(Connection con = DB.sql2o.open()) {
<<<<<<< HEAD
  		String sql = "DELETE FROM stylists WHERE id =:id";
=======
  		String sql = "DELETE FROM stylists WHERE id =: id";
>>>>>>> ce44c89af7a326666c57c5cbd788c446219eb77b
  		con.createQuery(sql)
  		.addParameter("id", id)
  		.executeUpdate();
    }
  }


}