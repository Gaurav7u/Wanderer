import React from 'react'
import {getRole,getToken} from '../../services/GetToken'
import { Navigate } from 'react-router-dom';

function AdminGuard({children}) {
    console.log(getRole())
    if(getToken() && getRole()=='admin'){
    
        return children
    }
  return <Navigate to='/login'/>
}

export default AdminGuard