package ru.vlapin.experiments.processing.model;

import static lombok.AccessLevel.*;

import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Entity
@Getter
@Builder
@ToString
@Setter(PRIVATE)
@RequiredArgsConstructor
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
public class Processing {

  //region id and version
  @Id
  @Include
  @GeneratedValue
  @Column(updatable = false, nullable = false)
  UUID id;

  @Version
  int version;
  //endregion

  @NonNull @Column(nullable = false) String card;
  @NonNull @Column(nullable = false) UUID accountId;

  //region equals and hashCode
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Processing that = (Processing) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
  //endregion

}
