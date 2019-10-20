import { User } from './user';
import { CurrentUserService } from './current-user.service';


export class BlogPost {

    id: number;
    userId: number;
    username: string;
    title: string;
    content: string;

}