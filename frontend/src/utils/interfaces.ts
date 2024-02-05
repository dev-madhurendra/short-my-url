export interface SocialLoginProps {
    text: string;
    src: string;
  }
  
export interface TypographyWithTextFieldProps {
  label: string;
  color: string;
  placeholder: string;
  value: string;
  onChange: (value: string) => void;
  isPassword: boolean;
  width?: string;
  height?: string | number;
  size?: "small" | "medium";
  borderRadius?: string | number;
  variant:any
}