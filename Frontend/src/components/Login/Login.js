import React from 'react'
import { useForm } from "react-hook-form";
import { ToastContainer, toast } from 'react-toastify';
import { Link, useNavigate } from "react-router-dom";
import LoginService from '../../services/LoginService';
import 'react-toastify/dist/ReactToastify.css';
import './Login.css'

function Login() {
  const { register, handleSubmit, formState: { errors } } = useForm({ mode: 'onChange' });
  let navigate = useNavigate();
  const regexEmail = /^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;

  const onSubmit = data => {
    LoginService.login(data).then((res) => {
      if (res.status == 200) {
        localStorage.setItem('userToken', JSON.stringify(res.data.token))
        localStorage.setItem('userRole', JSON.stringify(res.data.role))

        if (res.data.role == 'user') {
          navigate('/customer/dashboard')
        } else {
          navigate('/agency/dashboard')
        }
      }

    }
    ).catch(err => {
      console.log(err);
      toast.error('Invalid Credentials', { autoClose: 2000 });
    })
  }

  return (
    <div className='backgroundDiv'>
      <div className='inputs'>
        <h2>Login</h2>
        <form id='form' className='flex flex-col' onSubmit={handleSubmit(onSubmit)}>

          <input type="email" placeholder='Email' {...register("userName", { required: true, maxLength: 50, pattern: regexEmail })} />
          {errors.userName?.type === "required" && <span style={{ color: 'red' }}>"Email is required"</span>}
          {errors.userName?.type === "maxLength" && <span style={{ color: 'red' }}>"Maximum length exceeded"</span>}
          {errors.userName?.type === "pattern" && <span style={{ color: 'red' }}>"Email does not match with our policies"</span>}

          <input type="password" placeholder='Password' {...register("password", { required: true, maxLength: 16, minLength: 8 })} />
          {errors.password?.type === "required" && <span style={{ color: 'red' }}>"Password is required"</span>}
          {errors.password?.type === "maxLength" && <span style={{ color: 'red' }}>"Maximum length exceeded"</span>}
          {errors.password?.type === "minLength" && <span style={{ color: 'red' }}>"Must have atleast 8 characters"</span>}

          {errors.user?.type === "required" && "Required"}
          <button className='btn'>Login</button>
          <p>
            Not a member?<Link style={{ display: 'inline' }} className="nav-link" to={"/signup"}> Signup </Link>
          </p>
        </form>
        <ToastContainer />
      </div>
    </div>
  )
}

export default Login