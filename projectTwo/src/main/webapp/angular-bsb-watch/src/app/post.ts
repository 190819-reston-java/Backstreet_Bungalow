import { User } from './user';
import { CurrentUserService } from './current-user.service';


export class BlogPost{
    postid: number;
    subject: string;
    body: string;
    user: User;

    cs = new CurrentUserService;

    setUser() {
        this.user = this.cs.getUser();
    }
}