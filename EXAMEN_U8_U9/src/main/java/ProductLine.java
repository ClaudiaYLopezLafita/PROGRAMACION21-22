import java.util.Objects;

public class ProductLine {

    private String name;
    private String textDescription;
    private String Description;
    private String image;

    public ProductLine(String name, String textDescription, String description, String image) {
        this.name = name;
        this.textDescription = textDescription;
        Description = description;
        this.image = null;
    }

    public ProductLine() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ProductName='" + name + '\'' +
                ", textDescription='" + textDescription + '\'' +
                ", Description='" + Description + '\'' +
                ", image='" + image + '\'' +
                '}'+'\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductLine that = (ProductLine) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
