import { User } from './user';
import { CurrentUserService } from './current-user.service';


export class BlogPost{
    postid: number;
    subject: string;
    body: string;
    user: User;

}