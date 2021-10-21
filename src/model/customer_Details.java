package model;

public class customer_Details {
    private String id;
    private String name;
    private String contact;

    public customer_Details() {
    }

    public customer_Details(String id, String name, String contact) {
        this.setId(id);
        this.setName(name);
        this.setContact(contact);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "customer_Details{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}