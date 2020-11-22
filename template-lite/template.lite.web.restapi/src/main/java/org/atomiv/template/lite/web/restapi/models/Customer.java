package org.atomiv.template.lite.web.restapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The type Customer
 */
// @ApiModel(description="All details about the user")
// Create Entity Class
@Entity
@Table(name = "customers")
// @EntityListeners(AuditingEntityListener.class)

// prevent serialization error when GET sessions/2 in postman
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private Long id;

//    @Size(min=5, message="Name should have atleast 5 characters")
//    @ApiModelProperty(notes="name should have atleast 5 characters")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;


    @ManyToMany
    @JoinTable(
            name = "customer_addresses",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private List<Address> addresses;




    // update Getter and Setter if adding properties
//    @Column(name = "email_address", nullable = false)
//    private String email;
//
//    @Column(name = "created_at", nullable = false)
//    @CreatedDate
//    private Date createdAt;
//
//    @Column(name = "created_by", nullable = false)
//    @CreatedBy // @LastModifiedDate updatedAt, @LastModifiedBy updatedBy
//    private String createdBy;


//    @OneToMany(fetch=FetchType.LAZY)
//    private List<Customer_Orders> customerOrders;


    // protected Customer() {
    public Customer() {
    }



    //    public Customer(Long id, String firstName, String lastName) {
//        // TODO - why super()
//        super();
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }


    public Customer(Long id, String firstName, String lastName, List<Address> addresses) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addresses = addresses;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    // I suggest you make use of your IDE's features to generate the toString method. Don't hand-code it
    // This is not good practice ,as you are using string concatenation
    // StringBuilder is a better choice in such a situation
    // TODO what is the purpose of this
    @Override
    public String toString() {
        return "Customer {" +
                "id = " + id +
                ", name = " + firstName + '\'' +
                ", last name = " + lastName +
                " }";
    }


//    @Override
//    public String toString() {
//        return String.format(
//                "Customer[id=%s, firstName='%s', lastName='%s']",
//                id, firstName, lastName);
//    }

    // ----------------------------------------------

//    @Override
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//
//        String requestUrl = request.getRequestURI();
//        String name = requestUrl.substring("/people/".length());
//
//        Person person = DataStore.getInstance().getPerson(name);
//
//        if(person != null){
//            String json = "{\n";
//            json += "\"name\": " + JSONObject.quote(person.getName()) + ",\n";
//            json += "\"about\": " + JSONObject.quote(person.getAbout()) + ",\n";
//            json += "\"birthYear\": " + person.getBirthYear() + "\n";
//            json += "}";
//            response.getOutputStream().println(json);
//        }
//        else{
//            //That person wasn't found, so return an empty JSON object. We could also return an error.
//            response.getOutputStream().println("{}");
//        }
//    }

//    --------------------------------------------------------

//    @Override
//    public String toString() {
//        return new GsonBuilder().setPrettyPrinting().create().toJson(this);
//    }

    // Override toString() method java

    // If you need to call the method from the super class, then you need to do it by yourself by calling super.toString().

// -----------------------------------------

//    public String toString() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("First name : ").append(this.firstName).append("\n");
//        sb.append("Last name : ").append(this.lastName).append("\n");
//        sb.append("Email : ").append(this.email).append("\n");
//        return sb.toString();
//    }
//
//    public static void main(String args[]) {
//        ToStringExample example = new ToStringExample();
//        example.setFirstName("Testing");
//        example.setLastName("Tester");
//        example.setEmail("testing@tester.com");
//
//        System.out.println(example);
//    }




//    The above code outputs the following:
//
//    First name : Testing
//    Last name : Tester
//    Email : testing@tester.com
//
//    If we didn’t override the toString() method, the output would have been
//
//    io.devqa.tutorials.ToStringExample@60e53b93

//
// -----------------------------------------------------
}