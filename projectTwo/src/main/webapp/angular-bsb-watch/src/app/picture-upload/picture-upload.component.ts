import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-picture-upload',
  templateUrl: './picture-upload.component.html',
  styleUrls: ['./picture-upload.component.css']
})
export class PictureUploadComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  seleectedFile: File = null;
  pictureUploadUrl = "localhost:8080/Project2/picture-upload"

  onFileSelected(event) {
    this.seleectedFile = <File>event.target.files[0];
  }

  onUpload() {
    const formData = new FormData();
    formData.append('image', this.seleectedFile, this.seleectedFile.name);
    this.http.post(this.pictureUploadUrl, formData)
      .subscribe(response => {
        console.log(response);  
      })
  }

}
