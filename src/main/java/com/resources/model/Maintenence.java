package com.resources.model;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Maintenence {

	@Id
	@GeneratedValue(generator = "maintenence_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "maintenence_gen", sequenceName = "maintenence_seq", allocationSize = 1, initialValue = 1)
	private Integer maintenenceId;
	@Column(length = 30)
	private String maintenenceName;
	@Column(length = 30)
	private String maintenenceOwner;
	private LocalDate maintenenceStartDate;
	private LocalDate maintenenceEndDate;
	@Enumerated(EnumType.STRING)
	private Priority maintenencePriority;
	@Column(length = 30)
	@Enumerated(EnumType.STRING)
	private Status maintenenceStatus;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "maintenence_id")
	private Set<Task> taskList;
	@ManyToOne
	@JoinColumn(name = "trip_id")
	private Trip trip;

}
