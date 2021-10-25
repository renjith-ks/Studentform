package com.springbootmongodbcrud.sample.service;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.springbootmongodbcrud.sample.entity.CustomSeq;
import com.springbootmongodbcrud.sample.entity.Student;
import com.springbootmongodbcrud.sample.repository.UserRepository;



@Service
public class UserService {

	@Autowired
	 UserRepository sr;
	@Autowired
	 UserService ss;
	@Autowired
	private MongoOperations mongo;
	public int getNextSequence(String seqName)
	{
		 CustomSeq counter=mongo.findAndModify(
			query(where("_id").is(seqName)),
	        new Update().inc("sqe",1),
	       options().returnNew(true).upsert(true),
	   	       CustomSeq.class);
     	 return counter.getSqe();
	}
	
	  public Student saveStud(Student s) {
		  
			String s1=String.valueOf(ss.getNextSequence(Student.SEQUNCE_NAME));
			int i=s1.length();
			if(i==1)
			{
				
				String hai="R_"+"00"+s1;
				
				s.setId( hai);
				
			}else if(i==2) {
			
				String hai="R_"+"0"+s1;
				s.setId(hai);
			}else {
				
				
				s.setId("R_"+s1);
			}
		
			
         	sr.save(s);
			return s;
		}

	
	
	
	
	 public List<Student> getallbyname(){
		 List<Student>li=sr.findByOrderByNameAsc();
		 return li;
	 }

	

	

}