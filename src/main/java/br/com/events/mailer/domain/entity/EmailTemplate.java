package br.com.events.mailer.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class represents the email template's database table
 *
 * @author Gabriel Guimarães de Almeida
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "email_template")
public class EmailTemplate {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uuid;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "version", nullable = false)
    private String version;

    @Column(name = "content", nullable = false)
    private String content;
}
