export function getToken(){
    const userToken=localStorage.getItem('userToken')
    if(userToken!=null)
    {
        return `Bearer ${localStorage.getItem('userToken').replaceAll('"','')}`
    }
   
}
export function getServerPort(){
    return `8086`
}
export function getRole(){
    let role=localStorage.getItem('userRole');
    return role.replaceAll('"','')
  }

  export function Logout(){

    localStorage.removeItem('userToken')
    localStorage.removeItem('userRole')
    
  }