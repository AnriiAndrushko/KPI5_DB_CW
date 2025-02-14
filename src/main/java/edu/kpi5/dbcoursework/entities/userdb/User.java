package edu.kpi5.dbcoursework.entities.userdb;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;

@Node("User")
public class User {

    @Id
    private String login;

    @Property("password")
    private String password;

    @Relationship(type = "HAS_ACCESS_LEVEL", direction = Relationship.Direction.OUTGOING)
    private Set<AccessLevel> accessLevels = new HashSet<>();

    public User() {}

    public User(String login, String password, Set<AccessLevel> accessLevels) {

        this.login = login;

        this.password = password;

        this.accessLevels = accessLevels;
    }

    public String getLogin() {

        return login;
    }

    public String getPassword() {

        return password;
    }

    public Set<AccessLevel> getAccessLevel() {

        return accessLevels;
    }

    public void setLogin(String login) {

        this.login = login;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public void setAccessLevel(Set<AccessLevel> accessLevels) {

        this.accessLevels = accessLevels;
    }

    @Override
    public String toString() {
        return "User{" +
                ", login/id='" + login + '\'' +
                ", password='" + password + '\'' +
                ", accessLevel=" + accessLevels +
                '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        User user = (User) o;

        return login.equals(user.login);
    }

    @Override
    public int hashCode() {

        return login != null ? login.hashCode() : 0;
    }
}
