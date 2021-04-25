package petstore.models.pet;

import java.util.List;
import java.util.Objects;

public class Pet {
    private List<String> photoUrls;
    private String name;
    private long id;
    private Category category;
    private List<TagsItem> tags;
    private String status;

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<TagsItem> getTags() {
        return tags;
    }

    public void setTags(List<TagsItem> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pet)) return false;
        Pet pet = (Pet) o;
        return id == pet.id && Objects.equals(name, pet.name) && Objects.equals(category, pet.category) && Objects.equals(status, pet.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, category, status);
    }
}