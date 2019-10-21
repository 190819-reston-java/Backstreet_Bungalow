import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CurrentUserService } from '../current-user.service';

@Component({
  selector: 'app-picture-upload',
  templateUrl: './picture-upload.component.html',
  styleUrls: ['./picture-upload.component.css']
})
export class PictureUploadComponent implements OnInit {

  constructor(
    private http: HttpClient,
    private currentUser: CurrentUserService) { }

  ngOnInit() {
  }

  selectedFile: File = null;
  pictureUploadUrl = "http://localhost:8080/Project2/addPhoto"

  onFileSelected(event) {
    console.log(event);
    this.selectedFile = <File>event.target.files[0];
  }

  onUpload() {
    const formData = new FormData();
    formData.append('image', this.selectedFile, this.selectedFile.name);
    this.http.post(this.pictureUploadUrl, formData)
      .subscribe(response => {
        console.log(response);  
      })
  }

}
