import { User } from './user';

export class Photo {
    id: number;
    content_desc: string;
    content_hash: string;
    user: User;
}
