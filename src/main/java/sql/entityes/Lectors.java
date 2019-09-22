package sql.entityes;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Lectors {
    private int id_lector;
    private String lectorName;
    private long salary;
    private Short headOfDepartmentName;
    private Departments department;
    private Degree degree;

    @Id
    @Column(name = "id_lector")
    public int getId_lector() {
        return id_lector;
    }

    public void setId_lector(int id_lector) {
        this.id_lector = id_lector;
    }
    @Basic
    @Column(name = "lector_name")
    public String getLectorName() {
        return lectorName;
    }

    public void setLectorName(String lectorName) {
        this.lectorName = lectorName;
    }

    @Basic
    @Column(name = "salary")
    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }


    @Basic
    @Column(name = "head_of_department_name")
    public Short getHeadOfDepartmentName() {
        return headOfDepartmentName;
    }

    public void setHeadOfDepartmentName(Short headOfDepartmentName) {
        this.headOfDepartmentName = headOfDepartmentName;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_departament")
    public Departments getDepartment() {
        return department;
    }

    public void setDepartment(Departments departments) {
        this.department= departments;
    }

    @OneToOne
    @JoinColumn(name = "id_degree")
    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lectors lectors = (Lectors) o;
        return id_lector == lectors.id_lector &&
                Objects.equals(lectorName, lectors.lectorName) &&
                Objects.equals(salary, lectors.salary) &&
                Objects.equals(degree, lectors.degree) &&
                Objects.equals(headOfDepartmentName, lectors.headOfDepartmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_lector, lectorName, salary, degree, headOfDepartmentName, department);
    }

    @Override
    public String toString() {
        return "Lectors{" +
                "lectorName='" + lectorName + '\'' +
                ", headOfDepartmentName=" + headOfDepartmentName +
                ", department=" + department +
                ", degree=" + degree.getDegreeName() +
                '}';
    }
}
