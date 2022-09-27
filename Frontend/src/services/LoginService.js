import axios from 'axios'
import { getServerPort } from './GetToken';

export class LoginService{
    url=`http://localhost:${getServerPort()}`
  
    login(data){
        console.log(data)
       return axios.post(`${this.url}/user/authenticate`,data);

    }
}
export default new LoginService()