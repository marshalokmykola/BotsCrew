package sql.entityes;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Degree {
    private int id_degree;
    private String degreeName;

    @Id
    @Column(name = "id_degree")
    public int getId_degree() {
        return id_degree;
    }

    public void setId_degree(int id_degree) {
        this.id_degree = id_degree;
    }

    @Basic
    @Column(name = "degree_name")
    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Degree degree = (Degree) o;
        return id_degree == degree.id_degree &&
                Objects.equals(degreeName, degree.degreeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_degree, degreeName);
    }
}
