package com.company.enroller.persistence;

import com.company.enroller.model.Meeting;
import com.company.enroller.model.Participant;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
//@Component("meetingService")
public class MeetingService {

	Session session;
	DatabaseConnector connector;

	@Autowired
	public MeetingService(DatabaseConnector connector) {
		this.connector = connector;
		this.session = connector.getSession();
	}

	public Collection<Meeting> getAll() {
		String hql = "FROM Meeting";
		Query query = this.session.createQuery(hql, Meeting.class);
		return query.list();
	}

	public Meeting findById(long id) {
		return this.session.get(Meeting.class, id);
	}

	public Meeting add(Meeting meeting) {
		//Transaction transaction = connector.getSession().beginTransaction();
		Transaction transaction = session.beginTransaction();
		//connector.getSession().save(meeting);
		session.save(meeting);
		transaction.commit();
		return meeting;
	}

	public void delete(Meeting meeting) {
		//Transaction transaction = connector.getSession().beginTransaction();
		Transaction transaction = session.beginTransaction();
		//connector.getSession().delete(meeting);
		session.delete(meeting);
		transaction.commit();
	}

	public void update(Meeting meeting) {
		//Transaction transaction = connector.getSession().beginTransaction();
		Transaction transaction = session.beginTransaction();
		//connector.getSession().merge(meeting);
		session.merge(meeting);
		transaction.commit();
	}

}
