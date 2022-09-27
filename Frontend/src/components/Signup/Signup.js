import React, { useRef, useEffect, useState } from 'react'
import './Signup.css'
import { useForm } from "react-hook-form";
import { ToastContainer, toast } from 'react-toastify';
import { Link, useNavigate } from "react-router-dom";
import 'react-toastify/dist/ReactToastify.css';
import SignupService from '../../services/SignupService';

function Signup() {

  const { register, handleSubmit, reset, watch, formState: { errors } } = useForm({ mode: 'onChange' });
  let navigate = useNavigate();

  // const [fullname, setName] = useState('');
  // const [email, setEmail] = useState('');
  // const [mobile, setMobile] = useState('');
  // const [password, setPassWord] = useState('');
  // const [confirmPassword, setConfirmPassword] = useState('');
  // const [role, setRole] = useState('agency');

  const [user, setUser] = useState(null);

  const passwordd = useRef();
  passwordd.current = watch("password");

  useEffect(() => {
    // reset form with user data
    reset(user);
  }, [user]);

  // const onSubmit = data => {
  //   console.log(data);
  //   // setName('');
  //   toast.success("Signup Successful", { position: "top-center", autoClose: 2000 })

  //   // navigate("/login");
  // }

  const onSubmit = data => {
    SignupService.register(data).then(res => {
      if (res.status == 201) {
        toast.success("Registered Successfull")
        // navigate('/login');
      }
    }).catch(err => {
      SignupService.checkUserEmail(data.email).then(res => {
        if (res.data) {
          toast.error("User with Mail Id exist")
        }
      })
      SignupService.checkUserMobileNbr(data.mobile).then(res => {
        if (res.data) {
          toast.error("User with same Mobile number Exist ")
        }
      })
    })
  }

  const regexEmail = /^(([^<>()[\]\.,;:\s@\"]+(\.[^<>()[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
  const regexMobile = /[789][0-9]{9}/;

  return (
    <div className='backgroundDiv'>
      <div className='inputs'>
        <h2>Signup</h2>
        <span>Register to start planning your adventures</span>
        <form id='form' className='flex flex-col' onSubmit={handleSubmit(onSubmit)}>
          <input type="text" placeholder='Name' {...register("name", { required: true, maxLength: 20 })} />
          {errors.name?.type === "required" && <span style={{ color: 'red' }}>"Name is required"</span>}
          {errors.name?.type === "maxLength" && <span style={{ color: 'red' }}>"Maximum length exceeded"</span>}

          <input type="email" placeholder='Email' {...register("email", { required: true, maxLength: 50, pattern: regexEmail })} />
          {errors.email?.type === "required" && <span style={{ color: 'red' }}>"Email is required"</span>}
          {errors.email?.type === "maxLength" && <span style={{ color: 'red' }}>"Maximum length exceeded"</span>}
          {errors.email?.type === "pattern" && <span style={{ color: 'red' }}>"Email does not match with our policies"</span>}

          <input type="text" placeholder='Mobile Number' {...register("mobile", { required: true, maxLength: 10, minLength: 10, pattern: regexMobile })} />
          {errors.mobile?.type === "required" && <span style={{ color: 'red' }}>"Mobile Number is required"</span>}
          {errors.mobile?.type === "maxLength" && <span style={{ color: 'red' }}>"Maximum length exceeded"</span>}
          {errors.mobile?.type === "minLength" && <span style={{ color: 'red' }}>"Must have atleast 10 digits"</span>}
          {errors.mobile?.type === "pattern" && <span style={{ color: 'red' }}>"Mobile Number does not match with our policies"</span>}

          <input type="password" placeholder='Password' {...register("password", { required: true, maxLength: 16, minLength: 8 })} />
          {errors.password?.type === "required" && <span style={{ color: 'red' }}>"Password is required"</span>}
          {errors.password?.type === "maxLength" && <span style={{ color: 'red' }}>"Maximum length exceeded"</span>}
          {errors.password?.type === "minLength" && <span style={{ color: 'red' }}>"Must have atleast 8 characters"</span>}

          <input type="password" placeholder='Confirm Password' {...register("confirmPassword", {
            required: true, maxLength: 16, minLength: 8, validate: (value) =>
              value === passwordd.current
          })} />
          {errors.confirmPassword?.type === "required" && <span style={{ color: 'red' }}>"Confirm Password is required"</span>}
          {errors.confirmPassword?.type === "maxLength" && <span style={{ color: 'red' }}>"Maximum length exceeded"</span>}
          {errors.confirmPassword?.type === "minLength" && <span style={{ color: 'red' }}>"Must have atleast 8 characters"</span>}
          {errors.confirmPassword?.type === "validate" && <span style={{ color: 'red' }}>"Password and Confirm Password do not match"</span>}

          <select name="userType" id="userType" {...register("role", { required: true })}>
            <option value='admin'> Agency</option>
            <option value='user'>Customer</option>
          </select>
          {errors.user?.type === "required" && "Required"}
          <button className='btn'>Submit</button>
          <button onClick={() => reset()} className='btn'>Reset</button>
          <p>
            Already registered?<Link style={{ display: 'inline' }} className="nav-link" to={"/login"}> Login </Link>
          </p>
        </form>
        <ToastContainer />
      </div>
    </div>
  )
}

export default Signup