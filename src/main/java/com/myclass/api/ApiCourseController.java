package com.myclass.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.CourseDto;
import com.myclass.service.CourseService;

@RestController
@RequestMapping("api/course")
public class ApiCourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("")
	public Object get() {
		List<CourseDto> courses = courseService.findAll();
		return new ResponseEntity<Object>(courses, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public Object get(@PathVariable("id") int id) {
		try {
			CourseDto course = courseService.findById(id);
			return new ResponseEntity<Object>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>("khong tim thay du lieu!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("")
	public Object post(@RequestBody CourseDto dto) {
		try {
			courseService.add(dto);
			return new ResponseEntity<String>("them thanh cong", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<String>("Them that bai", HttpStatus.BAD_REQUEST);
		}
	}
	@PutMapping("")
	public Object put(@RequestBody CourseDto dto) {
		try {
			courseService.update(dto);
			return new ResponseEntity<String>("Cap nhat thanh cong", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("cap nhat that bai", HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/{id}")
	public Object delete(@PathVariable("id") int id) {
		try {
			courseService.delete(id);
			return new ResponseEntity<String>("Xoa thanh cong!", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Xoa that bai!", HttpStatus.BAD_REQUEST);
		}
	}
}
