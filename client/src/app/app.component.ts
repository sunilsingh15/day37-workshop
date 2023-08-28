import { Component, ElementRef, ViewChild, inject } from '@angular/core';
import { UploadService } from './upload.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'client';

  postID: string = '';
  service = inject(UploadService);

  @ViewChild('file')
  file!: ElementRef;

  @ViewChild('comments')
  comments!: ElementRef;

  processForm() {
    const uploadFile = this.file.nativeElement.files[0];
    const uploadComments = this.comments.nativeElement.value;

    let form = new FormData();

    form.set('picture', uploadFile);
    form.set('comments', uploadComments);


    this.service.uploadPost(form).subscribe(result => this.postID = result.success);

  }

}
