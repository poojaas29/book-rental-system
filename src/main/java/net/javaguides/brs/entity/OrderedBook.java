package net.javaguides.brs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orderedbooks")

public class OrderedBook {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ordered_book_id")
	private Long orderedBookId;

	@ManyToOne
	@JoinColumn(name = "book_id")
	private Book book;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Long getOrderedBookId() {
		return orderedBookId;
	}

	public void setOrderedBookId(Long orderedBookId) {
		this.orderedBookId = orderedBookId;
	}

}
