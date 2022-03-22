package bg.softuni.productshop.models.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryViewRootDto {

    @XmlElement(name = "category")
    private List<CategoryViewWithProductsCountAvgPriceAndTotalRevenue> categories;

    public List<CategoryViewWithProductsCountAvgPriceAndTotalRevenue> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryViewWithProductsCountAvgPriceAndTotalRevenue> categories) {
        this.categories = categories;
    }
}
