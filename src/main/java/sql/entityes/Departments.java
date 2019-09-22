package sql.entityes;

import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Departments {
    private int id_departament;
    private String departmentName;
    private List<Lectors> departamentLectors;

    @Id
    @Column(name = "id_departament")
    public int getId_departament() {
        return id_departament;
    }

    public void setId_departament(int id_departament) {
        this.id_departament = id_departament;
    }

    @Basic
    @Column(name = "department_name")
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="id_departament")
    public List<Lectors> getDepartamentLectors() {
        return departamentLectors;
    }

    public void setDepartamentLectors(List<Lectors> departamentLectors) {
        this.departamentLectors = departamentLectors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departments that = (Departments) o;
        return id_departament == that.id_departament &&
                Objects.equals(departmentName, that.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_departament, departmentName);
    }

    @Override
    public String toString() {
        return departmentName;
    }
}
