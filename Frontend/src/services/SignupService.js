import axios from 'axios'
import { getServerPort } from './GetToken';

export class SignupService{
    url=`http://localhost:${getServerPort()}`
  
    register(data){
        console.log(data)
       return axios.post(`${this.url}/user/`,data);

    }
    checkUserEmail(email) {
        return axios.get(`${this.url}/user/checkUserEmail/` + email);
      }
      // checkUserName(userName) {
      //   return axios.get(`${this.url}/user/checkUserName/` + userName);
      // } 
      checkUserMobileNbr(mobileNbr) {
        return axios.get(`${this.url}/user/checkUserMobile/` + mobileNbr);
       }
}
export default new SignupService()