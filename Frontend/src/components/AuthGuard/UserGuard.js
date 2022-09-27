import React from 'react'
import { Navigate } from 'react-router-dom';
import {getRole,getToken} from '../../services/GetToken';
function UserGuard({children}) {
   
    
    console.log(getRole())
    if(getToken() && getRole()=='user'){
    
        return children
    }
  return <Navigate to='/login'/>
}

export default UserGuard