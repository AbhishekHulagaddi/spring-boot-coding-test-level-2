package com.accenture.codingtest.springbootcodingtest.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.codingtest.springbootcodingtest.model.ProjectModel;
import com.accenture.codingtest.springbootcodingtest.service.ProjectService;

@RestController
@RequestMapping("/v1")
@SuppressWarnings("rawtypes")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
		
		@PostMapping(value = "/Project/Project")
		@PreAuthorize("hasAuthority('ROLE_PRODUCT_OWNER')")
		@Secured("ROLE_PRODUCT_OWNER")
		public ResponseEntity<ProjectModel> project(@RequestBody ProjectModel projectModel) throws Exception {
			ProjectModel projectModel1 = projectService.project(projectModel);
	        return new ResponseEntity<>(projectModel1, HttpStatus.CREATED);
	        }
		
		@PutMapping(value = "/Project/updateProjectIdempotent")
		@PreAuthorize("hasAuthority('ROLE_PRODUCT_OWNER')")
		@Secured("ROLE_PRODUCT_OWNER")
		public ResponseEntity<String> updateProjectIdempotent(@PathVariable UUID id) throws Exception{
			ProjectModel projectModel = projectService.getProjectById(id);
			return new ResponseEntity<>(projectService.updateProjectIdempotent(projectModel), HttpStatus.OK);
		}
		
		@PatchMapping(value = "/Project/updateProject")
		@PreAuthorize("hasAuthority('ROLE_PRODUCT_OWNER')")
		@Secured("ROLE_PRODUCT_OWNER")
		public ResponseEntity<String> updateProjects (@PathVariable UUID id) throws Exception{
			ProjectModel projectModel = projectService.getProjectById(id);
			return new ResponseEntity<>(projectService.updateProjects(projectModel,null), HttpStatus.OK);
		}
		
		@DeleteMapping(value = "/Project/DeleteProject")
		public ResponseEntity<String> deleteProjectById (@PathVariable UUID id) throws Exception{
			return new ResponseEntity<>(projectService.deleteProjectById(id), HttpStatus.OK);
		}
		
		@GetMapping(value = "/Project/GetProjectById")
		public ResponseEntity<ProjectModel> getProjectById (@PathVariable UUID id) throws Exception{
			return new ResponseEntity<>(projectService.getProjectById(id), HttpStatus.OK);
		}
		
		@GetMapping(value = "/Project/GetAllProjects")
		public ResponseEntity<List<ProjectModel>> getAllProjects () throws Exception{
			return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
		}
		
		
		
}


